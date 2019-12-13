function2(0, Out):-
	Out = 0.

function2(1, Out):-
	Out = 1.

function2(N, Out):-
	N2 is N - 2,
	N3 is N - 1,
	function2(N2, Out2),
	function2(N3, Out3),
	Out4 is Out3 * 2,
	Out is Out2 + Out4.
