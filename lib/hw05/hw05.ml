(** Homework 5: Problem 2 *)


(** Part 1 *)

(* unzip: ('a * 'b) list -> 'a list * 'b list *)
let rec unzip xys =
  match xys with
  | [] -> ([], [])
  | (x, y) :: xys1 ->
      let xs, ys = unzip xys1 in
      (x :: xs, y :: ys)

    
(** Part 2 *)
    
(* drop: int -> 'a list -> 'a list *)
let drop n xs =
  let rec d m xs =
    match xs with
    | [] -> []
    | x :: xs1 ->
        if m == n
        then d 1 xs1
        else x :: d (m + 1) xs1
  in
  d 1 xs
    
(** Part 3 *)

(* reverse: 'a list -> 'a list *)
let reverse xs =
  let rec rev acc = function
    | [] -> acc
    | x :: xs -> rev (x :: acc) xs
  in rev [] xs

(* concat: 'a list -> 'a list -> 'a list *)
let concat xs ys =
  let rec concat_tail acc = function
    | [] -> acc                                        
    | x :: xs -> concat_tail (x :: acc) xs
  in concat_tail ys (reverse xs)

