function1(0, Out):-
	Out is 1.

function1(1, Out):-
	Out is 4.

function1(N, Out):-
	N \== 0,
	N2 is N - 1,
	function1(N2, Out2),
	Out is 4 * Out2.
