select B.USER_ID, B.NICKNAME, SUM(PRICE) TOTAL_SALES
from used_goods_board A
inner join used_goods_user B on A.writer_id = B.user_id
where A.status = 'DONE'
group by WRITER_ID
having TOTAL_SALES >= 700000
order by TOTAL_SALES
