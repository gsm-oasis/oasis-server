INSERT INTO user(user_id, anniversary_time, code, dating_date, email, nickname, password, question_time, today) values ('adminId', 5, 'o4KlNO0H', 0, 'shgur7236@naver.com','admin','$2a$10$5gLLAwYnrS614Ay3bVc4E.vnJZ/0a0blCNkm1m9p5SyVKJoQFY8/K','12:00','20221212');

INSERT INTO diary(title,content,mood,writer, user_id, create_date) values ('제목','일기 내용~~~~~','행복','노혁','adminId','20221215');

# INSERT INTO photo()
#
# INSERT INTO diary_photo(diary_diary_id, photo_file_id) VALUES (1,1);

INSERT INTO question(id,content) values (1,'상대방의 첫인상을 말해주세요');
INSERT INTO question(id,content) values (2,'상대방의 장점 4가지만 말해주세요');
INSERT INTO question(id,content) values (3,'자신의 약점을 말해보세요');
INSERT INTO question(id,content) values (4,'상대방의 닮은 동물은 무엇이 있을까요?');
INSERT INTO question(id,content) values (5,'상대방의 닮은 사람은?');


