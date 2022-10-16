open Hw05
open Util.Print

(* Add testing code here. To compile and run, execute:
   $ dune exec bin/main.exe
*)
 
  
let _ =
  let ints, strings = unzip [(1, "a"); (2, "b")] in
  print_endline @@ ilist_to_string ints;
  print_endline @@ slist_to_string strings
