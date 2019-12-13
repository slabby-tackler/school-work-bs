join2(String1, String2, Newstring):-
	name(String1, L1), name(String2, L2),
	append(L1, L2, Newlist),
	name(Newstring, Newlist).

join3(String1, String2, String3, Newstring):-
	join2(String1, String2, S),
	join2(S, String3, Newstring).

join4(String1, String2, String3, String4, Newstring):-
	join3(String1, String2, String3, S),
	join2(S, String4, Newstring).
