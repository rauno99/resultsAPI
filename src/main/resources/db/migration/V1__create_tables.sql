create table choices (id bigserial not null, text varchar(255), votes int4 not null, poll_id int8 not null, primary key (id));
create table polls (id bigserial not null, question varchar(255), active boolean, primary key (id));
alter table choices add constraint FK1i68hpih40n447wqx4lpef6ot foreign key (poll_id) references polls;