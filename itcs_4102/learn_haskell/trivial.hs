main = do
	putStrLn("What is your name?") --asks user for name; output portion of program
	name <- getLine --takes in the user's name; input portion of program
	putStrLn("Hello " ++ name ++ ", this is our sample program") --shows the value that we took in
	putStrLn("The main data structure is a list. This is the one we will use:")
	let a = [5,6,8,4,2,6,7,6,5,8,6,5,8,1] --list to be working with
	print a
	putStrLn("Haskell has some functions for lists, such as reverse:")
	print(reverse a)
	putStrLn("as well as tail and init")
	print(tail a)
	print(init a)
	putStrLn("")
	putStrLn("The main control structre for haskell is recursion. Adding this way on our list gives:")
	--temp variables; probably not best practice but it was the only way I could get them to work
	let tempList = tail a
	let temp = head a
	let sum = addValues temp tempList
	print(sum)
	
addValues a b = do
	if null b
		then 0 + a
		else do
			let tempList = tail b
			let temp = head b
			a + (addValues temp tempList)
