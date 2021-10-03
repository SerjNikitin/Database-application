INSERT INTO public.position (position_id, title, salary) VALUES (6, 'H&R manager', 2000);
INSERT INTO public.position (position_id, title, salary) VALUES (2, 'Java middle depelopers', 1400);
INSERT INTO public.position (position_id, title, salary) VALUES (9, 'Java junior developer', 1000);
INSERT INTO public.position (position_id, title, salary) VALUES (10, 'hr employee', 900);
INSERT INTO public.position (position_id, title, salary) VALUES (11, 'Java Senior', 2500);

INSERT INTO public.employee (emp_id, date_birth_day, first_name, last_name, patronymic, gender) VALUES (12, '1990-09-20', 'annova', 'anna', 'annovna', 'wuman');
INSERT INTO public.employee (emp_id, date_birth_day, first_name, last_name, patronymic, gender) VALUES (13, '1990-09-20', 'petr', 'petrov', 'petrovich', 'man');
INSERT INTO public.employee (emp_id, date_birth_day, first_name, last_name, patronymic, gender) VALUES (14, '1990-09-20', 'sergeev', 'sergey', 'sergeivich', 'man');
INSERT INTO public.employee (emp_id, date_birth_day, first_name, last_name, patronymic, gender) VALUES (15, '1990-09-20', 'nikitin', 'nikita', 'nikitich', 'man');
INSERT INTO public.employee (emp_id, date_birth_day, first_name, last_name, patronymic, gender) VALUES (16, '1990-09-20', 'kirillov', 'kirill', 'kirilevich', 'man');

INSERT INTO public.department (dep_id, name, phone, email) VALUES (4, 'Stuards department', 56443, 'ggg@ggg');
INSERT INTO public.department (dep_id, name, phone, email) VALUES (5, 'H&R department', 88005355, 'hr@mail.ru');
INSERT INTO public.department (dep_id, name, phone, email) VALUES (7, 'Developers department', 5666765, 'ggg@ggg');

INSERT INTO public.department_manager (emp_id, dep_id) VALUES (14, 7);
INSERT INTO public.department_manager (emp_id, dep_id) VALUES (12, 5);
INSERT INTO public.department_manager (emp_id, dep_id) VALUES (13, 4);

INSERT INTO public.employee_department (emp_id, department_id) VALUES (14, 7);
INSERT INTO public.employee_department (emp_id, department_id) VALUES (12, 5);
INSERT INTO public.employee_department (emp_id, department_id) VALUES (15, 7);
INSERT INTO public.employee_department (emp_id, department_id) VALUES (13, 5);
INSERT INTO public.employee_department (emp_id, department_id) VALUES (16, 7);

INSERT INTO public.employee_position (emp_id, position_id) VALUES (14, 11);
INSERT INTO public.employee_position (emp_id, position_id) VALUES (12, 10);
INSERT INTO public.employee_position (emp_id, position_id) VALUES (15, 9);
INSERT INTO public.employee_position (emp_id, position_id) VALUES (13, 10);
INSERT INTO public.employee_position (emp_id, position_id) VALUES (16, 9);
