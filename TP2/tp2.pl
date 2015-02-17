/*Question 1 */
longueur([] , 0).
longueur([_|Q] , A)  :- longueur(Q , B),A is B+1.
/*Question 2 */
somme([],0).
somme([T|Q],A) :- somme(Q,B), A is B+T.
/*Question 3 */
membre(_,[]) :- false.
membre(A,[A|_]) :- true.
membre(A,[_|Q]) :- membre(A,Q).
/*Question 4*/
ajoute_en_tete(A,B,L) :- L = [A|B].
/* Question 5 */
ajoute_en_queue(A,[],[A]).
ajoute_en_queue(A,[T|B],L)  :- ajoute_en_queue(A,B,L2), L = [T|L2],!. 
/* Question 6 */
extraire_tete(L,X,L2) :- ajoute_en_tete(X,L2,L).
/*Question 7 */
concatene(L1,[],L1).
concatene([],L2,L2).
concatene([T|Q],L2,L) :- concatene(Q, L2, L3),  L = [T|L3].
/*Question 8 */
retourne([],[],[]).
retourne(T,[],A) :- A is T.
retourne([T|Q],[],A) :- retourne(Q,T,A).
/*Question 9 */
insert_trie(A,[],[A]).
insert_trie(A,[T|Q],L) :- T < A,insert_trie(A,Q,L1), L = [T|L1],!.
insert_trie(A,[T|Q],[A|L1]) :- A =< T, L1 = [T|Q].
/*Question 10 */
tri_insert([],[]).
tri_insert([T|Q],L) :- tri_insert(Q,L2), insert_trie(T,L2,L).
/*Question 11 */
divise([],[],[]).
divise([T|Q],[T|L1],L2) :- divise(Q,L2,L1).
/*Question 12 */
fusion([],[],[]).
fusion(A,B,[A,B]).
fusion([T1|Q1],[T2|Q2],L) :- fusion(T1,T2,L).
