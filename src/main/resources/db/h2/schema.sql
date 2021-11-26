 create table board (
       id bigint generated by default as identity,
        content varchar(255),
        title varchar(30) not null,
        user_id bigint,
        primary key (id)
    );

    create table role (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table user (
       id bigint generated by default as identity,
        enabled boolean,
        password varchar(255),
        username varchar(255),
        primary key (id)
    );

    create table user_role (
       user_id bigint not null,
        role_id bigint not null
    );

    alter table board
       add constraint FKfyf1fchnby6hndhlfaidier1r
       foreign key (user_id)
       references user;

    alter table user_role
       add constraint FKa68196081fvovjhkek5m97n3y
       foreign key (role_id)
       references role;

    alter table user_role
       add constraint FK859n2jvi8ivhui0rl0esws6o
       foreign key (user_id)
       references user;