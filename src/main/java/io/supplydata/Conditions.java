package io.supplydata;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Conditions {

	
public  final static Predicate<String> LOWERCASE=s->s.contains("s");

public  final static Predicate<String> NOTCONTAINS=s->!s.contains("s");

public  final static Predicate<String> NOTEMPTY=s->!s.isEmpty();

public final static Consumer<String> GETTITLE = s->System.out.println(s);

public final static Consumer<Integer> PRINTVAL = s->System.out.println(s);

public final static BiConsumer<Integer, Integer> MULTIPLY = (s,i)->System.out.println(s*i);








}
