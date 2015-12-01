-- test for trigger_afterInsertOnPublicQuestions_updateScores & trigger_afterUpdateOnPublicQuestionsToUser_updateScores

USE APP;

-- CREATE USERS

INSERT INTO `app`.`users`
VALUES (1,'THISISAHASH1','THISISANOTHERHASH1','UNAME1',NOW(),0,'','DE');

INSERT INTO `app`.`users`
VALUES (2,'THISISAHASH2','THISISANOTHERHASH2','UNAME2',NOW(),0,'','DE');

INSERT INTO `app`.`users`
VALUES (3,'THISISAHASH3','THISISANOTHERHASH3','UNAME3',NOW(),4,'','DE');

INSERT INTO `app`.`users`
VALUES (4,'THISISAHASH4','THISISANOTHERHASH4','UNAME4',NOW(),5,'','DE');

INSERT INTO `app`.`users`
VALUES (5,'THISISAHASH5','THISISANOTHERHASH5','UNAME5',NOW(),7,'','DE');

INSERT INTO `app`.`users`
VALUES (6,'THISISAHASH6','THISISANOTHERHASH6','UNAME6',NOW(),100,'','DE');

-- CREATE PUBLIC QUESTIONS

INSERT INTO `app`.`publicquestions`
VALUES (1,'THISISAQUESTION','THIS IS ADD INFO',1,'',NOW(),NOW(),'DE',0,default);

INSERT INTO `app`.`publicquestions`
VALUES (2,'THISISAQUESTION','THIS IS ADD INFO',3,'',NOW(),NOW(),'DE',0,default);

INSERT INTO `app`.`publicquestions`
VALUES (3,'THISISAQUESTION','THIS IS ADD INFO',3,'',NOW(),NOW(),'DE',0,default);

-- Now:
	-- the user 1 should have 10 point
	-- the user 3 should have 19 point

-- CHECK

SELECT userID,username,scoreOfGlobal FROM users WHERE userID = 1 OR userID = 3;

-- CREATE ANSWERS PUBLIC QUESTION

INSERT INTO `app`.`answerspublicquestions`
VALUES (1,1,'THISISAANSWER');

INSERT INTO `app`.`answerspublicquestions`
VALUES (2,1,'THISISAANSWER');

INSERT INTO `app`.`answerspublicquestions`
VALUES (3,1,'THISISAANSWER');

INSERT INTO `app`.`answerspublicquestions`
VALUES (4,2,'THISISAANSWER');

INSERT INTO `app`.`answerspublicquestions`
VALUES (5,2,'THISISAANSWER');


-- CREATE PUBLIC QUESTIONS TO USERS

INSERT INTO `app`.`publicquestionstousers`
VALUES(1,1,2);

INSERT INTO `app`.`publicquestionstousers`
VALUES(1,2,3);

INSERT INTO `app`.`publicquestionstousers`
VALUES(2,3,1);

INSERT INTO `app`.`publicquestionstousers`
VALUES(2,4,1);


-- NOW
	-- User 1: Now:10 + answer:1 + sombdyAns:1 + answer:1 = 13
	-- User 2: Now:0 + answer:1
	-- User 3: Now:19 + answer:1 + smbdyAns:1 + sombyAns:1 = 22
    -- User 4: Now:5 + answer:1 = 6
    
-- CHECK

SELECT userID,username,scoreOfGlobal FROM users;