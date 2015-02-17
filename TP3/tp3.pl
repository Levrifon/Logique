/*DEBUE Rémy */
grille([[_,_,_,_,_,_,_,_,_], 
	[_,_,_,_,_,3,_,8,5],
	[_,_,1,_,2,_,_,_,_],
	[_,_,_,5,_,7,_,_,_],
	[_,_,4,_,_,_,1,_,_],
	[_,9,_,_,_,_,_,_,_],
	[5,_,_,_,_,_,_,7,3],
	[_,_,2,_,1,_,_,_,_],
	[_,_,_,_,4,_,_,_,9]]).
	
/*Question 1 */
printline([]) 		:- writeln('|'),!.
printline([T|Q]) 	:- printline2(T) , printline(Q),!.
printline2(A) 		:- integer(A),!,write('|'),write(A).
/* on arrive dans cette derniere branche si A n'est pas un nombre */
printline2(_)		:- write('| ').

/*Question 2 */
myprint([]).
myprint([T|Q]) :- printline(T),myprint(Q).
/*Question 3 */
bonnelongueur([],0)	:- N =:= 0.
bonnelongueur([_|Q],N)	:- bonnelongueur(Q,(N-1)).
/*Question 4 */
bonnetaille([],0).
bonnetaille([T|Q],N)	:- bonnelongueur(T,N), bonnetaille(Q,N),!. 	
bonnetaille([T],N)	:- bonnelongueur(T,N).
/*Question 5 */
:- use_module(library(clpfd)).
verifie([]).
verifie([T|Q]) :- all_different(T), T ins 1..9, verifie(Q).
/*Question 6 */
eclate([T|Q],[T1|L1],L) :- 	eclate(Q,L1,Z), L = [[T|T1]|Z].
eclate([T|Q],[],L) :-		eclate(Q,[],Z),	L = [[T]|Z]. 
eclate([],L2,L2).
/*Question 7 */
transp([],[]).
transp([T|Q],L) :- eclate(T,R,L), transp(Q,R),!.
/*Question 8 */
decoupe([],[],[],[]).
decoupe([A1,A2,A3|L1],
	[B1,B2,B3|L2],
	[C1,C2,C3|L3],L) :-  L = [[A1,A2,A3,B1,B2,B3,C1,C2,C3]|Q], decoupe(L1,L2,L3,Q).
/*Question 9 */
carres([[]],[[]]).
carres([[A,B,C]|Q],L) :- decoupe(A,B,C,R) , carres(Q,R2), L = [R|R2].  
/*carres([[1,2,3,4,5,6],[7,8,9,10,11,12],[13,14,15,16,17,18]], L).
decoupe([1,2,3,..],[7,8,9...],[13,14,15,...]*/
    	   		
