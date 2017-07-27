module GradePointAverage (calculate) where
import Helper

calculate = do
	putStrLn("What is your current GPA?")
	tmp <- getLine
	let oldGPA = conDouble tmp
	putStrLn("How many total hours of courses have you taken?")
	tmp <- getLine
	let totalHours = conDouble tmp
	putStrLn("How many courses are you currently taking?")
	tmp <- getLine
	let numberOfCourses = conDouble tmp
	putStrLn("How many hours is each class you are taking?")
	tmp <- getLine
	let hoursPerClass = conDouble tmp
	putStrLn("What is your GPA average for this semester?")
	tmp <- getLine
	let currentGPA = conDouble tmp
	let newGPA = ((totalHours * oldGPA) + (numberOfCourses * hoursPerClass) * currentGPA) / (totalHours + numberOfCourses * hoursPerClass)
	putStrLn("Your new GPA is:")
	print newGPA

