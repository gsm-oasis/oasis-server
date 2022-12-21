INSERT INTO question(id,content) values (0,'상대방의 첫인상을 말해주세요');
INSERT INTO question(id,content) values (1,'상대방의 첫인상을 말해주세요');
INSERT INTO question(id,content) values (2,'상대방의 장점 4가지만 말해주세요');
INSERT INTO question(id,content) values (3,'자신의 약점을 말해보세요');
INSERT INTO question(id,content) values (4,'상대방의 닮은 동물은 무엇이 있을까요?');
INSERT INTO question(id,content) values (5,'상대방의 닮은 사람은?');
INSERT INTO question(id,content) values (6,'상대방의 첫인상을 말해주세요');
INSERT INTO question(id,content) values (7,'상대방의 장점 4가지만 말해주세요');
INSERT INTO question(id,content) values (8,'자신의 약점을 말해보세요');
INSERT INTO question(id,content) values (9,'상대방의 닮은 동물은 무엇이 있을까요?');
INSERT INTO question(id,content) values (10,'상대방의 닮은 사람은?');
INSERT INTO question(id,content) values (11,'상대방의 첫인상을 말해주세요');
INSERT INTO question(id,content) values (12,'상대방의 장점 4가지만 말해주세요');
INSERT INTO question(id,content) values (13,'자신의 약점을 말해보세요');
INSERT INTO question(id,content) values (14,'상대방의 닮은 동물은 무엇이 있을까요?');
INSERT INTO question(id,content) values (15,'상대방의 닮은 사람은?');
INSERT INTO question(id,content) values (16,'상대방의 첫인상을 말해주세요');
INSERT INTO question(id,content) values (17,'상대방의 장점 4가지만 말해주세요');
INSERT INTO question(id,content) values (18,'자신의 약점을 말해보세요');
INSERT INTO question(id,content) values (19,'상대방의 닮은 동물은 무엇이 있을까요?');
INSERT INTO question(id,content) values (20,'상대방의 닮은 사람은?');
INSERT INTO question(id,content) values (21,'상대방의 첫인상을 말해주세요');
INSERT INTO question(id,content) values (22,'상대방의 장점 4가지만 말해주세요');
INSERT INTO question(id,content) values (23,'자신의 약점을 말해보세요');
INSERT INTO question(id,content) values (24,'상대방의 닮은 동물은 무엇이 있을까요?');
INSERT INTO question(id,content) values (25,'상대방의 닮은 사람은?');
INSERT INTO question(id,content) values (26,'상대방의 첫인상을 말해주세요');
INSERT INTO question(id,content) values (27,'상대방의 장점 4가지만 말해주세요');
INSERT INTO question(id,content) values (28,'자신의 약점을 말해보세요');
INSERT INTO question(id,content) values (29,'상대방의 닮은 동물은 무엇이 있을까요?');
INSERT INTO question(id,content) values (30,'상대방의 닮은 사람은?');
INSERT INTO question(id,content) values (31,'상대방의 첫인상을 말해주세요');
INSERT INTO question(id,content) values (32,'상대방의 장점 4가지만 말해주세요');
INSERT INTO question(id,content) values (33,'자신의 약점을 말해보세요');
INSERT INTO question(id,content) values (34,'상대방의 닮은 동물은 무엇이 있을까요?');
INSERT INTO question(id,content) values (35,'상대방의 닮은 사람은?');
INSERT INTO question(id,content) values (36,'상대방의 첫인상을 말해주세요');
INSERT INTO question(id,content) values (37,'상대방의 장점 4가지만 말해주세요');
INSERT INTO question(id,content) values (38,'자신의 약점을 말해보세요');
INSERT INTO question(id,content) values (39,'상대방의 닮은 동물은 무엇이 있을까요?');
INSERT INTO question(id,content) values (40,'상대방의 닮은 사람은?');

INSERT INTO heart(level) values (1);
INSERT INTO heart(level) values (2);
INSERT INTO heart(level) values (3);
INSERT INTO heart(level) values (4);
INSERT INTO heart(level) values (5);
INSERT INTO heart(level) values (6);
INSERT INTO heart(level) values (7);

INSERT INTO user(user_id, is_couple,anniversary_date, code, couple_id, dating_date, email, first_day, nickname, password, today, heart_level) VALUES ('adminId', true,'7', 'o4KLNO0H', 'testId', '9', 'shgur7236@naver.com', '20221210', '곽희상', '$2a$10$5gLLAwYnrS614Ay3bVc4E.vnJZ/0a0blCNkm1m9p5SyVKJoQFY8/K', '20221212', '1');

INSERT INTO user(user_id, is_couple,anniversary_date, code, couple_id, dating_date, email, first_day, nickname, password, today, heart_level) VALUES ('testId', true,'7', 'h64OW2u3', 'adminId', '9', 'shgur7236@naver.com', '20221210', '진시윤', '$2a$10$5gLLAwYnrS614Ay3bVc4E.vnJZ/0a0blCNkm1m9p5SyVKJoQFY8/K', '20221212', '1');


INSERT INTO diary(title,content,mood,writer, user_id, create_date) values ('제목','일기 내용~~~~~','행복','노혁','adminId','20221215');


# update user set is_couple = false where is_couple = true;

