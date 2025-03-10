# https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/?envType=study-plan-v2&envId=top-sql-50
SELECT t2.unique_id, t1.name
FROM Employees AS t1
LEFT JOIN EmployeeUNI t2 ON t1.id = t2.id;

# https://leetcode.com/problems/invalid-tweets/?envType=study-plan-v2&envId=top-sql-50
SELECT tweet_id FROM Tweets
WHERE length(content) > 15

# https://leetcode.com/problems/article-views-i/?envType=study-plan-v2&envId=top-sql-50
SELECT DISTINCT author_id as id FROM Views
WHERE author_id = viewer_id
ORDER BY author_id;

# https://leetcode.com/problems/big-countries/?envType=study-plan-v2&envId=top-sql-50
SELECT name, population, area  FROM World
WHERE area >= 3000000 OR population >= 25000000

# https://leetcode.com/problems/find-customer-referee/?envType=study-plan-v2&envId=top-sql-50
SELECT name FROM Customer
WHERE referee_id != '2' || referee_id is null

# https://leetcode.com/problems/recyclable-and-low-fat-products/?envType=study-plan-v2&envId=top-sql-50
SELECT product_id FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y'