# Write your MySQL query statement below
SELECT id, if(p_id is null, 'Root', if(p_id is not null and id in (select p_id from Tree), 'Inner', 'Leaf')) as type FROM Tree;