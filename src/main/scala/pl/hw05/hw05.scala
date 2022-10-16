package pl.hw05

import scala.annotation.tailrec

object hw05 extends App:

  // Problem 1: Tail Recursion

  // Naive inefficient implementation of binom used for testing
  def binomNaive(n: Int, k: Int): Int = 
    require (0 <= k && k <= n)
    if n == k || k == 0 then 1 
    else binomNaive(n - 1, k - 1) + binomNaive(n - 1, k)
  
  @tailrec def binomHelper(n: Int, m: Int, d: Int, ans: Int): Int =
    if n == m && d <= 1 then ans
    else if d > 1 && ans % d == 0 then binomHelper(n, m, d - 1, ans / d)
    else binomHelper(n - 1, m, d, ans * n)
  
  
  // Your implementation of Part 1
  def binom(n: Int, k: Int): Int = 
    require (0 <= k && k <= n)
    binomHelper(n, k, n - k, 1)
  
  
  // Naive inefficient implementation of trib used for testing
  def tribNaive(n: Int): Int = 
    require (0 <= n)
    n match 
      case 0 | 1 => 0
      case 2 => 1
      case _ => tribNaive(n - 1) + tribNaive(n - 2) + tribNaive(n - 3)

  def tribHelper(n: Int, t1: Int, t2: Int, t3: Int): Int = 
    n match 
      case 0 | 1 => t2
      case 2 => t1
      case _ => tribHelper(n - 1, t1 + t2 + t3, t1, t2)
  
  // Your implementation of Part 2
  def trib(n: Int): Int =
    require(0 <= n)
    tribHelper(n, 1, 0, 0)

