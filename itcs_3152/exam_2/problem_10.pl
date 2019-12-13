Y sis A and B:-
	findall(X,(member(X,A),member(X,B)),Y),!.

Y sis A or B:-
	findall(X, (member(X,A);member(X,B)),Y),!.

Y sis A - B:-
	findall(X, (member(X,A),not(member(X,B))),Y),!.
