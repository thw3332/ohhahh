create table oh_member(
 id varchar2(15) primary key,
 pw varchar2(20),
 name nvarchar2(10),                       
 birth date,
 phone number(11),
 addr varchar2(300)
);

//회원


create table oh_category(
 cate_code number primary key, 
 cate_name varchar2(100)
);

create sequence oh_category_seq;


//카테고리


create table oh_item(
 item_code number primary key, --상품번호
 cate_code number references oh_category(cate_code), --카테고리번호
 item_name varchar2(100), --상품이름
 item_price number, --가격
 item_img varchar2(200), --메인이미지
 item_detailimg varchar2(100), --상세이미지
 item_date date --상품제조일
);



create sequence oh_item_seq;

insert into oh_category values(oh_category_seq.NEXTVAL,'TOP');
insert into oh_category values(oh_category_seq.NEXTVAL,'BOTTOM');
insert into oh_category values(oh_category_seq.NEXTVAL,'ACC');


//상품


create table oh_cart(
 cart_code number primary key, 
 item_code number references oh_item(item_code),
 id varchar2(15) references oh_member(id),
 cart_cnt number,
 cart_see varchar(2) --y,n
);

create sequence oh_cart_seq;


insert into oh_item values(oh_item_seq.NEXTVAL,1,'RIBBON ST SLEEVELESS (BROWN)',44100,'top/oh1.jpg','top/oh1_detail.jpg', '2020-08-11');
insert into oh_item values(oh_item_seq.NEXTVAL,1,'CHERRY OPS (PURPLE)',80100,'top/oh2.jpg','top/oh2_detail.jpg', '2020-08-12');
insert into oh_item values(oh_item_seq.NEXTVAL,1,'CHERRY OPS (GREEN)',80100,'top/oh3.jpg','top/oh3_detail.jpg', '2020-08-13');

insert into oh_item values(oh_item_seq.NEXTVAL,2,'STITCH DENIM SHORTS',62100,'bottom/oh4.jpg','bottom/oh4_detail.jpg', '2020-08-14');
insert into oh_item values(oh_item_seq.NEXTVAL,2,'MULTI JOGGER PANTS (BLUE)',79000,'bottom/oh5.jpg','bottom/oh5_detail.jpg', '2020-08-15');
insert into oh_item values(oh_item_seq.NEXTVAL,2,'MULTI JOGGER PANTS (BLACK)',79000,'bottom/oh6.jpg','bottom/oh6_detail.jpg', '2020-08-16');

insert into oh_item values(oh_item_seq.NEXTVAL,3,'ST BELL BAG (RED)',48600,'acc/oh7.jpg','acc/oh7_detail.jpg', '2020-08-17');
insert into oh_item values(oh_item_seq.NEXTVAL,3,'ST BELL BAG (BLACK)',48600,'acc/oh8.jpg','acc/oh8_detail.jpg', '2020-08-18');
insert into oh_item values(oh_item_seq.NEXTVAL,3,'SPELLING MUFFLER (NAVY)',35100,'acc/oh9.gif','acc/oh9_detail.jpg', '2020-08-19');


insert into oh_item values(oh_item_seq.NEXTVAL,1,'X HALF TURTLE NECK (BLACK)',36000,'top/oh10.jpg','top/oh10_detail.jpg', '2020-08-20');
insert into oh_item values(oh_item_seq.NEXTVAL,1,'X HALF TURTLE NECK (BROWN)',36000,'top/oh11.jpg','top/oh11_detail.jpg', '2020-08-21');

insert into oh_item values(oh_item_seq.NEXTVAL,2,'ETHNIC SKIRT (RED)',42000,'bottom/oh13.jpg','bottom/oh13_detail.jpg', '2020-08-23');

insert into oh_item values(oh_item_seq.NEXTVAL,3,'SPELLING MUFFLER (BROWN)',39000,'acc/oh16.gif','acc/oh16_detail.jpg', '2020-08-26');
insert into oh_item values(oh_item_seq.NEXTVAL,3,'CHECK DOA FUR BAG',35100,'acc/oh17.jpg','acc/oh17_detail.jpg', '2020-08-27');
insert into oh_item values(oh_item_seq.NEXTVAL,3,'NEON JACKET (DEEP DENIM)',102000,'acc/oh18.jpg','acc/oh18_detail.jpg', '2020-08-28');


//장바구니

create table oh_board(
 board_code number primary key,
 id varchar2(15) references oh_member(id),
 board_title varchar2(1000),
 board_pw varchar2(20),
 board_img varchar2(100),
 board_content varchar2(3000),
 board_date date,
 board_cnt number
);


create sequence oh_board_seq;

alter table oh_board add ref number;
alter table oh_board add re_step number;
alter table oh_board add re_level number;

//최근 본 상품

create table oh_recent_item(
 recent_item_code number primary key,
 item_code number references oh_item(item_code), --상품번호
 id varchar2(15) references oh_member(id), --유저아이디
 recent_date date
);

create sequence oh_recent_item_seq;

//게시판

alter table oh_member add DETAILADDR varchar2(1000);
alter table oh_member add POSTCODE varchar2(5);