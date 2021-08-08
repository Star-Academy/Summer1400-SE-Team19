SELECT StudentNumber  , AVG(Score) AS GPA INTO studentAndAvarge  FROM newTable GROUP BY StudentNumber; 
SELECT TOP(3)  studentAndAvarge.StudentNumber , FirstName , LastName , GPA INTO phase7  FROM  studentAndAvarge
 LEFT JOIN Students ON studentAndAvarge.StudentNumber = Students.StudentNumber ORDER BY GPA DESC;