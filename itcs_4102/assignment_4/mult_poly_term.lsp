(defun multiply-poly-term (poly term)
	(if (null poly) nil
		(cons (list (* (car (car poly)) (car term)) (+ (car (cdr (car poly))) (car (cdr term)))) (multiply-poly-term (cdr poly) term))
	)
)
