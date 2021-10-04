create table position
(
    position_id serial
        constraint position_pk
            primary key,
    title       text    not null,
    salary      integer not null
);

alter table position
    owner to postgres;

create table employee
(
    emp_id         bigserial
        constraint employee_pk
            primary key,
    date_birth_day date not null,
    first_name     text not null,
    last_name      text not null,
    patronymic     text not null,
    gender         text not null
);

alter table employee
    owner to postgres;

create unique index employee_emp_id_uindex
    on employee (emp_id);

create table department
(
    dep_id bigserial
        constraint department_pk
            primary key,
    name   text    not null,
    phone  integer not null,
    email  text    not null
);

alter table department
    owner to postgres;

create unique index department_dep_id_uindex
    on department (dep_id);

create table employee_position
(
    emp_id      bigint not null
        constraint employee_position_employee_emp_id_fk
            references employee,
    position_id bigint not null
        constraint employee_position_position_position_id_fk
            references position,
    constraint employee_position_pk
        primary key (emp_id, position_id)
);

alter table employee_position
    owner to postgres;

create table department_manager
(
    emp_id bigint not null
        constraint department_manager_employee_emp_id_fk
            references employee
            on delete cascade,
    dep_id bigint not null
        constraint department_manager_department_dep_id_fk
            references department,
    constraint department_manager_pk
        primary key (emp_id, dep_id)
);

alter table department_manager
    owner to postgres;

create table employee_department
(
    emp_id        integer not null
        constraint employee_department_employee_emp_id_fk
            references employee,
    department_id integer not null
        constraint employee_department_department_dep_id_fk
            references department,
    constraint employee_department_pk
        primary key (emp_id, department_id)
);

alter table employee_department
    owner to postgres;