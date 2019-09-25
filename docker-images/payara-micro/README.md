# Payara Micro image

This docker image is a base image for other microprofile applications

Just ADD the jar to a new image based on this image in the `/opt/payara/deployments`
directory.


# Build

from the `docker-images` folder run:

* for local build

```bash
make payara-micro
```

* for release

```bash
make release-payara-micro
```

Don't forget to edit the `makefile.env` to set the correct values for your release
