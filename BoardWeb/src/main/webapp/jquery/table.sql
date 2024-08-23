create table tbl_schedule(
    title varchar2(300) not null,
    start_date varchar2(20) not null,
    end_date varchar2(20)
    
);
insert into tbl_schedule(
    title,
    start_date,
    end_date
)
values(
    '여름휴가',
    '2024-08-18',
    '2024-08-25'
);
insert into tbl_schedule(
    title,
    start_date,
    end_date
)
values(
    '발표 회의',
    '2024-08-26T16:00:00',
    '2024-08-26'
);
insert into tbl_schedule(
    title,
    start_date,
    end_date
)
values(
    '발표 회의',
    '2024-08-26T16:00:00',
    '2024-08-26T18:00:00'
);
insert into tbl_schedule(
    title,
    start_date
)
values(
    '여행',
    '2024-08-30'
);
commit;

select *
from tbl_schedule;
desc tbl_schedule;

		delete 	tbl_schedule
		where		title = '123'
		and			start_date = '2024-08-01'
		and			end_date = '2024-08-02';
        rollback;