parent(chester,irvin).
parent(chester,clarence).
parent(chester,mildred).
parent(irvin,ron).
parent(irvin,ken).
parent(clarence,shirley).
parent(clarence,charlie).
parent(mildred,mary).
male(chester).
female(mildred).
male(irvin).
female(shirley).
male(clarence).
female(sharon).
male(ron).
female(mary).
male(ken).
male(charlie).
father(X,Y):-parent(X,Y),male(X).
grandparent(X,Y):-father(X,Z),parent(Z,Y).
paternalgrandfather(X,Y):-father(X,Z),father(Z,Y).
sibling(X,Y):-parent(Z,X), parent(Z,Y), \+ (X=Y).
ancestor(X,Y):-parent(X,Y).
ancestor(X,Y):-parent(X,Z), ancestor(Z,Y).
parent(ken,nora).
female(nora).
parent(ken,elizabeth).
female(elizabeth).
