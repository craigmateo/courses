(*Helper function*)
fun same_string(s1 : string, s2 : string) =
    s1 = s2

(*1 a.*)

(*Takes string and list and returns option NONE if string not in list or option SOME list if string in list, where list is the original list with the string removed.*)

fun all_except_option (str, lst) =
  case lst of
    [] => NONE
  | x::xs' => case same_string(str,x) of
      true => SOME xs'
    | false => case all_except_option(str, xs') of
        NONE => NONE
  | SOME y => SOME(x::y);

(*1 b.*)

(*Takes a string list list (a list of list of strings, the substitutions) and a string s and returns a string list. The result has all the strings that are in some list in substitutions that also has s, but s itself should not be in the result.*)

fun get_substitutions1 (lls, s) =
  case lls of
    [] => []
  | x::xs => getOpt(all_except_option(s, x),[])@get_substitutions1(xs,s);

(*1 c.*)

(*get_substitutions2 is like get_substitutions1 except it uses a tail-recursive local helper function.*)

fun get_substitutions2 (lls, s) =
  let fun aux(lls, s, acc) =
    case lls of
      [] => acc
      | (x :: xs) => case all_except_option(s, x) of 
                       NONE => aux(xs, s, acc)
                       | SOME(ys) =>  aux(xs, s, acc @ ys)
  in
    aux(lls, s, [])
  end;

get_substitutions2([["Fred","Fredrick"],["Jeff","Jeffrey"],["Geoff","Jeff","Jeffrey"]],
"Jeff")=["Jeffrey", "Geoff", "Jeffrey"];

(*1 d.*)

(* function similar_names, takes a string list list of substitutions (as in parts (b) and (c)) and a full name of type {first:string,middle:string,last:string} and returns a list of full
names (type {first:string,middle:string,last:string} list). The result is all the full names you
can produce by substituting for the first name (and only the first name) using substitutions and parts (b) or (c).*)

type Name = {first:string, middle:string, last:string};

fun similar_names (subs, name) =
  let fun aux(subs, acc) =
    case subs of
      [] => acc
      | (x::xs) => aux(xs, acc @ [{first=x, middle=(#middle name), last=(#last name)}]) 
  in
    aux(get_substitutions2(subs, #first name), [name])
  end

val similar_names_test_1 = similar_names ([["Fred","Fredrick"],["Elizabeth","Betty"],["Freddie","Fred","F"]], {first="Fred", middle="W", last="Smith"}) =
	    [{first="Fred", last="Smith", middle="W"},
         {first="Fredrick", last="Smith", middle="W"},
	     {first="Freddie", last="Smith", middle="W"},
         {first="F", last="Smith", middle="W"}];

datatype suit = Clubs | Diamonds | Hearts | Spades;
datatype rank = Jack | Queen | King | Ace | Num of int ;
type card = suit * rank;
datatype color = Red | Black;
exception NotAllowed;
datatype move = Discard of card | Draw;

(*2 a.*)

(*function card_color, takes a card and returns its color.*)

fun card_color (suit, rank) = 
  case suit of
    Spades => Black
    | Clubs => Black
    | Diamonds => Red
    | Hearts => Red;

(*tests*)
card_color (Clubs, Ace) = Black;
card_color (Hearts, Num 3) = Red;

(*2 b.*)

(*function card_value, takes a card and returns its value (num returns value, aces are 11, everything else is 10).*)

fun card_value (suit, rank) =
  case rank of
      Jack => 10
    | Queen => 10
    | King => 10
    | Ace => 11
    | Num i => i;

(*tests*)

card_value (Hearts, Num 4)=4;
card_value (Clubs, Ace)=11;
card_value (Spades, Jack)=10;

(*2 c.*)

(*function remove_card, takes a list of cards cs, a card c, and an exception e. It returns a list that has all the elements of cs except c. If c is in the list more than once, remove only the first one. If c is not in the list, raise the exception e.*)

fun remove_card (cs, c, e) =
  case cs of
    [] => raise e
  | x::xs => case c = x of
      true => xs
    | false => case remove_card(xs, c, e) of
            [] => [x]
          | y::ys => x::y::ys;

remove_card ([(Clubs, Ace), (Diamonds, Num 2), (Hearts, Jack)], (Diamonds, Num 2), NotAllowed);

(*2 d.*)

(*function all_same_color, takes a list of cards and returns true if all the cards in the list are the same color.*)

fun all_same_color (cs) =
  case cs of
    [] => true
    | x::[] => true
    | x::y::tail => case card_color(x) = card_color(y) of
          true => all_same_color(y::tail)
        | false => false;

all_same_color [(Clubs, Ace), (Diamonds, Num 2), (Hearts, Jack)]=false;
all_same_color [(Diamonds, Ace), (Diamonds, Num 2), (Hearts, Jack)]=true;

(*2 e.*)

(*function sum_cards, takes a list of cards and returns the sum of their values*)

fun sum_cards (cs) =
  let fun aux (cs, acc) =
    case cs of
      [] => acc
      | x::xs => aux(xs, acc + card_value(x))
  in
    aux(cs, 0)
  end;

sum_cards [(Hearts, Num 4),(Spades, Jack)] = 14;

(*2 f.*)

(* function score, takes a card list (the held-cards) and an int (the goal) and computes
the score as described above *)

fun score (cs, goal) = 
  let fun acc (cs) =
    case (sum_cards(cs), goal) of
      (sum, goal) => case sum > goal of
                       true => (sum - goal) * 3
                       | false => goal - sum
  in
    case all_same_color(cs) of
      true => acc(cs) div 2
      | false => acc(cs)
  end;

(*2 g.*)

fun officiate (cs, ms, goal) =
  let fun process_moves(cs, ms, held) =
      case ms of
        [] => held
        | m::ms_tail => case m of
                          Discard card => process_moves(cs, ms_tail, remove_card(held, card, NotAllowed))
                          | Draw => case cs of
                                      [] => held
                                      | c::_ => case sum_cards(c::held) > goal of
                                                  true => c::held
                                                  | false => process_moves(remove_card(cs, c, NotAllowed), ms_tail, c::held)
                                                       
                                                       
  in
    score(process_moves(cs, ms, []), goal) 
  end;