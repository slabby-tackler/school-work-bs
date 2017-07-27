(defun convert_grade (letter)
	(case letter
		((a a+) 4.0)
		(b+ 3.33)
		(b 3.0)
		(b- 2.67)
		(c+ 2.33)
		(c 2.0)
		(c- 1.67)
		(d+ 1.33)
		((d d-) 1.0)
		(otherwise 0.0)
	)
)

(defun calc_points (grade_list)
	(if (null (car grade_list)) 0
		(+ (convert_grade (car grade_list)) (calc_points (cdr grade_list)))
	)
)

(defun gpa (grade_list)
	(/ (calc_points grade_list) (length grade_list))
)
