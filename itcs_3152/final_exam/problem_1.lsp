(defun problem_1 (n)
	(case n
		(0 0)
		(1 7)
		(otherwise (+ (problem_1 (- n 2)) (* 3 (problem_1 (- n 1)))))
	)
)
