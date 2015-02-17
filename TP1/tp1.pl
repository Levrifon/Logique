/*Choix possibles */
contenu(princesse).
contenu(tigre).
contenu(vide).
/*Question 2 */
pancarte1(tigre,_).
pancarte1(_,princesse).

pancarte2(princesse,_).
/*Question 3*/
salle1(X,Y) :- 
	pancarte1(X,Y), pancarte2(X,Y),
	contenu(X),contenu(Y).
salle1(X,Y) :- 
	not(pancarte1(X,Y)), not(pancarte2(X,Y)),
	contenu(X),contenu(Y).
/*Question 4
Quelle que soit la porte ouverte, une princesse sera derrière.
*/

/*Question 7*/
pancarte12(princesse,tigre).
pancarte22(princesse,tigre).
pancarte22(tigre,princesse).
salle2(X,Y) :- contenu(X),contenu(Y),
		not(pancarte12(X,Y)),pancarte22(X,Y),write(X),write(' '),write(Y).
salle2(X,Y) :- 	contenu(X),contenu(Y),
		pancarte12(X,Y),not(pancarte22(X,Y)),write(X),write(' '),write(Y).
/* Question 8 :
Dans la salle de gauche = tigre
dans la salle de droite = princesse */

/*Question 10 : 
La pancarte qui disait la vérité était la deuxième
*/
/*Question 11 : on utilise write */

/*Question 12 */
pancarte31(_,_,vide).
pancarte32(tigre,_,_).
pancarte33(_,_,vide).
/*Cas ou la princesse est dans la salle 1 */
princesse1(X,Y,Z) :- contenu(X) = contenu(princesse),
			contenu(X) \= contenu(Y),
			contenu(Y) \= contenu(Z),
			contenu(X) \= contenu(Z).
/*Cas ou la princesse est dans la salle 2 */			
princesse2(X,Y,Z) :- contenu(Y) = contenu(princesse),
			contenu(X) \= contenu(Y),
			contenu(Y) \= contenu(Z),
			contenu(X) \= contenu(Z).
/*Cas ou la princesse est dans la salle 3 */			
princesse3(X,Y,Z) :- contenu(Z) = contenu(princesse),
			contenu(X) \= contenu(Y),
			contenu(Y) \= contenu(Z),
			contenu(X) \= contenu(Z).
/*Debut princesse porte 1,donc porte 1 vraie */			    
salle3(X,Y,Z) :- contenu(X),contenu(Y),contenu(Z),
			princesse1(X,Y,Z), 
			pancarte31(X,Y,Z),
			not(pancarte32(X,Y,Z)),
			pancarte33(X,Y,Z).
		
salle3(X,Y,Z) :- contenu(X),contenu(Y),contenu(Z),
			princesse1(X,Y,Z), 
			pancarte31(X,Y,Z),
			pancarte32(X,Y,Z),
			not(pancarte33(X,Y,Z)).	
			
salle3(X,Y,Z) :- contenu(X),contenu(Y),contenu(Z),
			pancarte31(X,Y,Z),
			not(pancarte32(X,Y,Z)),
			not(pancarte33(X,Y,Z)).
/* FIN princesse porte 1*/		
/* idem pour les autres salles */		
salle3(X,Y,Z) :- contenu(X),contenu(Y),contenu(Z),
			princesse2(X,Y,Z), 
			not(pancarte31(X,Y,Z)),
			pancarte32(X,Y,Z),
			pancarte33(X,Y,Z).
		
salle3(X,Y,Z) :- contenu(X),contenu(Y),contenu(Z),
			princesse2(X,Y,Z), 
			pancarte31(X,Y,Z),
			pancarte32(X,Y,Z),
			not(pancarte33(X,Y,Z)).
		
salle3(X,Y,Z) :- contenu(X),contenu(Y),contenu(Z),
			princesse2(X,Y,Z), 
			not(pancarte31(X,Y,Z)),
			pancarte32(X,Y,Z),
			not(pancarte33(X,Y,Z)).
salle3(X,Y,Z) :- contenu(X),contenu(Y),contenu(Z),
			princesse3(X,Y,Z), 
			not(pancarte31(X,Y,Z)),
			pancarte32(X,Y,Z),
			pancarte33(X,Y,Z).
		
salle3(X,Y,Z) :- contenu(X),contenu(Y),contenu(Z),
			princesse3(X,Y,Z), 
			pancarte31(X,Y,Z),
			not(pancarte32(X,Y,Z)),
			pancarte33(X,Y,Z).
		
salle3(X,Y,Z) :- contenu(X),contenu(Y),contenu(Z),
			princesse3(X,Y,Z), 
			not(pancarte31(X,Y,Z)),
			not(pancarte32(X,Y,Z)),
			pancarte33(X,Y,Z).
		
/* Question 14 : Solution = (princesse,tigre,vide).*/

		


