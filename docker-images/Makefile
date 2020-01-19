#
# Copyright 2019 Ivo Woltring <WebMaster@ivonet.nl>
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#


# import config.
# You can change the default config with `make cnf="config_special.env" build`
cnf ?= makefile.env
include $(cnf)
export $(shell sed 's/=.*//' $(cnf))

DOCKERFILES=$(shell find * -type f -name Dockerfile)
IMAGES=$(subst /,\:,$(subst /Dockerfile,,$(DOCKERFILES)))
RELEASE_IMAGE_TARGETS=$(addprefix release-,$(IMAGES))

# HELP
# This will output the help for each task
# thanks to https://marmelab.com/blog/2016/02/29/auto-documented-makefile.html
.PHONY: help $(IMAGES) $(RELEASE_IMAGE_TARGETS)

help: projects ## This help
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_-]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST);
	@echo ">>> make sure to have 'jq' installed."

.DEFAULT_GOAL := help

projects: ## prints which projects have build targets
	@for fo in $(IMAGES);                                                                 \
	do                                                                                    \
		echo $$fo | awk '{printf "\033[36m%-30s\033[0m Builds %s\n", $$1, $$1}';          \
		echo $$fo | awk '{printf "\033[36mrelease-%-22s\033[0m Releases %s\n", $$1, $$1}';\
	done

$(IMAGES): %: ## builds a specific project by its directory name
	docker build -t $(REGISTRY)/$@ $(subst :,/,$@)

$(RELEASE_IMAGE_TARGETS): %: ## release a single image from the project
	@project=$(subst release-,,$@);                                           \
	docker build --no-cache -t $(REGISTRY)/$$project $(subst :,/,$$project);  \
	docker tag $(REGISTRY)/$$project:latest $(REGISTRY)/$$project:$(VERSION); \
	docker push $(REGISTRY)/$$project:latest;                                 \
	docker push $(REGISTRY)/$$project:$(VERSION);

all: build  ## Build all the images in the project as 'latest'

build: ## Build all the images in the project as 'latest'
	@for img in $(IMAGES);                                                    \
	do                                                                        \
		docker build -t $(REGISTRY)/$$img $(subst :,/,$$img) ;                \
	done

build-nc: ## Build all the images in the project as 'latest' (no-cache)
	@for img in $(IMAGES);                                                    \
	do                                                                        \
		docker build --no-cache -t $(REGISTRY)/$$img $(subst :,/,$$img) ;     \
	done                                                                      \

tag: ## Tags all the images to the VERSION as found int makefile.env
	@for img in $(IMAGES);                                                    \
	do                                                                        \
		docker tag $(REGISTRY)/$$img:latest $(REGISTRY)/$$img:$(VERSION) ;    \
	done

version: build tag ## Builds and versions all the images in this project

release: build-nc publish ## Make a release by building and publishing the `{version}` and `latest` tagged containers to the registry

# Docker publish
publish: publish-latest publish-version ## Publish the `{version}` and `latest` tagged containers to the registry

publish-latest:
	@for img in $(IMAGES); do                                                 \
		docker push $(REGISTRY)/$$img:latest ;                                \
	done

publish-version: tag
	@for img in $(IMAGES); do                                                 \
		docker push $(REGISTRY)/$$img:$(VERSION) ;                            \
	done

clean: rm-containers rmi-version rmi-latest ## Cleans up the mess you made
	@echo "Cleaning dangling images in general";                              \
	for img in $(docker images --filter dangling=true -q); do                 \
		echo Deleting dangling image $$img;                                   \
		docker rmi $$img ;                                                    \
	done;                                                                     \
	for img in $(docker images | grep "^<none>" | awk '{print $3}'); do       \
	    echo Deleting <none> image $$img;                                     \
		docker rmi $$img;                                                     \
	done

deep-clean: clean rmi-base-images ## same as clean plus removal of base images
	@echo "Finished.";

rmi-version: ## Removes all the local images from this project with the defined version
	@echo Removing all images with version $(VERSION) from this project;      \
	for cont in $$(docker images -q);                                         \
	do                                                                        \
		cname=$$(docker inspect $$cont|jq '.[0].RepoTags[0]'|sed 's/\"//g');  \
		for img in $(IMAGES);                                                 \
		do                                                                    \
			if [ $(REGISTRY)/$$img:$(VERSION) == $$cname ];                   \
			then                                                              \
				docker rmi $$cname 2>/dev/null;                               \
			fi                                                                \
		done                                                                  \
	done

rmi-latest: ## Removes all the local images from this project with the 'latest' tag
	@echo Removing all images with version 'latest' from this project;        \
	for cont in $$(docker images -q);                                         \
	do                                                                        \
		cname=$$(docker inspect $$cont|jq '.[0].RepoTags[0]'|sed 's/\"//g') ; \
		for img in $(IMAGES);                                                 \
		do                                                                    \
			if [ $(REGISTRY)/$$img:latest == $$cname ];                       \
			then                                                              \
				docker rmi $$cname 2>/dev/null;                               \
			fi                                                                \
		done                                                                  \
	done

rmi-base-images: ## Removes all the base (FROM) images used in the projects
	@echo "Removing all the base (FROM) images used in the projects";         \
	baseimgs=$$(find . -type f -name Dockerfile -exec grep ^FROM {} \; | sed 's/FROM //g');\
	for base in $$baseimgs;                                                   \
	do                                                                        \
	    noversion=$$(echo $$base|sed 's/:.*//');                              \
	    if [ "$$noversion" == "$$base" ];                                     \
	    then                                                                  \
	       echo "No version fount, assumong latest";                          \
	       base="$$base:latest";                                              \
	    fi;                                                                   \
	    echo "$$base";                                                        \
		for cont in $$(docker images -q);                                     \
		do                                                                    \
		    cname=$$(docker inspect $$cont|jq '.[0].RepoTags[0]'|sed 's/\"//g') ; \
			if [ $$base == $$cname ];                                         \
			then                                                              \
        	    echo "Removing base-image: $$base";                           \
				docker rmi $$base 2>/dev/null;                                \
			fi                                                                \
		done                                                                  \
	done

rm-containers: stop ## Stops and removes running containers based on the images in this project
	@echo Removing all created containers from this project;                  \
	for cont in $$(docker ps -aq);                                            \
	do                                                                        \
		cname=$$(docker inspect $$cont | jq .[].Config.Image | sed 's/\"//g');\
		for img in $(IMAGES);                                                 \
		do                                                                    \
			if [ $(REGISTRY)/$$img == $$cname ];                              \
			then                                                              \
				echo Removing container: $$cname -\> $$cont;                  \
				docker rm -f $$cont >/dev/null;                               \
			fi                                                                \
		done                                                                  \
	done

stop: ## Stops all running containers based on the images in this project
	@echo Stopping all running containers from this project;                  \
	for cont in $$(docker ps -q);                                             \
	do                                                                        \
		cname=$$(docker inspect $$cont | jq .[].Config.Image | sed 's/\"//g');\
		for img in $(IMAGES);                                                 \
		do                                                                    \
			if [ $(REGISTRY)/$$img == $$cname ];                              \
			then                                                              \
				echo Stopping container: $$cname -\> $$cont;                  \
				docker stop $$cont >/dev/null;                                \
			fi                                                                \
		done                                                                  \
	done
