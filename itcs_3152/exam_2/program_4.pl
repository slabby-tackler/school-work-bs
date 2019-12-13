subset([],[]).
subset([X|L],[X|S]):-
	subset(L,S).
subset(L,[_|S]):-
	subset(L,S).

Y sis A and B:-
	findall(X,(member(X,A),member(X,B)),Y),!.

