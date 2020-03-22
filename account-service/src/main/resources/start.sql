create keyspace springcloud
with replication = {'class':'SimpleStrategy', 'replication_factor' : 3};


use springcloud;

create table emp(
    emp_id int PRIMARY KEY ,
    emp_name text,
    emp_city text,
    emp_sal varint,
    emp_phone varint
);

create table accounts(
                    id text PRIMARY KEY ,
                    uname text,
                    email text,
                    pwd text,
                    created_at date,
                    is_active boolean
);

select *  from emp;