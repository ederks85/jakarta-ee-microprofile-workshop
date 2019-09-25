CREATE DATABASE if NOT EXISTS `quote`;
USE quote;
DROP TABLE IF EXISTS `quote`;

CREATE TABLE IF NOT EXISTS `quote` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `author` varchar(250) NOT NULL,
  `quote` text  NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `quote` (`author`, `quote`) VALUES('Anonymous', 'A dirty mind is a joy forever.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Unsourced', 'A Fool with a Tool is Still a Fool, but at least know your tool fool.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Putts law', 'Technology is dominated by two types of people. Those who understand what they do not manage and those who manage what they do not understand.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Edward V Berard', 'Walking on water and developing software from a specification are easy if both are frozen.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Rich Kulawiec', 'Any sufficiently advanced bug is indistinguishable from a feature.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Unknown', 'It''s not a bug - it''s an undocumented feature.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Unknown', 'I really hate this darn machine; I wish that they would sell it.It will not do what I want it to, but only what I tell it.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Jessica Gaston', 'One man''s crappy software is another man''s full time job.');
INSERT INTO `quote` (`author`, `quote`) VALUES('John Moore', 'He who hasn''t hacked assembly language as a youth has no heart. He who does so as an adult has no brain. ');
INSERT INTO `quote` (`author`, `quote`) VALUES('Richard Pattis', 'If you cannot grok the overall structure of a program while taking a shower, e.g., with no external memory aids, you are not ready to code it.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Nathaniel S. Borenstein', 'It should be noted that no ethically-trained software engineer would ever consent to write a DestroyBaghdad procedure. Basic professional ethics would instead require him to write a DestroyCity procedure, to which Baghdad could be given as a parameter.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Doug Vargas', 'It''s easy to cry "bug" when the truth is that you''ve got a complex system and sometimes it takes a while to get all the components to co-exist peacefully');
INSERT INTO `quote` (`author`, `quote`) VALUES('Steve McConnell', 'It''s okay to figure out murder mysteries, but you shouldn''t need to figure out code. You should be able to read it.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Andy Hertzfeld', 'It''s the only job I can think of where I get to be both an engineer and an artist. There''s an incredible, rigorous, technical element to it, which I like because you have to do very precise thinking. On the other hand, it has a wildly creative side where the boundaries of imagination are the only real limitation. ');
INSERT INTO `quote` (`author`, `quote`) VALUES('C.A.R. Hoare, quoted by Donald Knuth', 'We should forget about small efficiencies, say about 97% of the time: premature optimization is the root of all evil.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Harlan Mills', 'Programming is similar to a game of golf. The point is not getting the ball in the hole but how many strokes it takes. ');
INSERT INTO `quote` (`author`, `quote`) VALUES('Lazy programmers', 'Errors have occurred. We won''t tell you where or why.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Alan J. Perlis', 'One man''s constant is another man''s variable. ');
INSERT INTO `quote` (`author`, `quote`) VALUES('Alan J. Perlis', 'There are two ways to write error-free programs; only the third one works.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Lawrence Flon', 'There does not now, nor will there ever exist, a programming language in which it is the least bit hard to write bad programs.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Unknown', 'When a programming language is created that allows programmers to program in simple English, it will be discovered that programmers cannot speak English.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Richard Pattis', 'When debugging, novices insert corrective code; experts remove defective code. ');
INSERT INTO `quote` (`author`, `quote`) VALUES('C.A.R. Hoare', 'You cannot teach beginners top-down programming, because they don''t know which end is up. ');
INSERT INTO `quote` (`author`, `quote`) VALUES('Alan J. Perlis', 'In programming, as in everything else, to be in error is to be reborn. ');
INSERT INTO `quote` (`author`, `quote`) VALUES('Douglas Adams', 'What I mean is that if you really want to understand something, the best way is to try and explain it to someone else. That forces you to sort it out in your own mind. And the more slow and dim-witted your pupil, the more you have to break things down into more and more simple ideas. And that''s really the essence of programming. By the time you''ve sorted out a complicated idea into little steps that even a stupid machine can deal with, you''ve certainly learned something about it yourself. ');
INSERT INTO `quote` (`author`, `quote`) VALUES('Ian Robinson', 'Be of the web, not behind the web');
INSERT INTO `quote` (`author`, `quote`) VALUES('Douglas Adams', 'It''s not the fall that kills you; it''s the sudden stop at the end.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Putt''s Corollary', 'Every technical hierarchy, in time, develops a competence inversion.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Filbert principle', 'leadership is nature''s way of removing morons from the productive flow');
INSERT INTO `quote` (`author`, `quote`) VALUES('Nathan Myhrvold', 'Software sucks because users demand it to.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Jamie Zawinski', 'Linux is only free if your time has no value.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Donald Knuth', 'Beware of bugs in the above code; I have only proved it correct, not tried it.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Steve McConnell', 'Good code is its own best documentation. As you''re about to add a comment, ask yourself, "How can I improve the code so that this comment isn''t needed?" Improve the code and then document it to make it even clearer.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Eagleson''s law', 'Any code of your own that you haven''t looked at for six or more months might as well have been written by someone else.');
INSERT INTO `quote` (`author`, `quote`) VALUES('Chris Heilmann', 'Java is to JavaScript what Car is to Carpet.');
