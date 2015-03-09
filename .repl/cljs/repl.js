// Compiled by ClojureScript 0.0-2727 {}
goog.provide('cljs.repl');
goog.require('cljs.core');
cljs.repl.print_doc = (function print_doc(m){
cljs.core.println.call(null,"-------------------------");

cljs.core.println.call(null,[cljs.core.str((function (){var temp__4126__auto__ = new cljs.core.Keyword(null,"ns","ns",441598760).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(temp__4126__auto__)){
var ns = temp__4126__auto__;
return [cljs.core.str(ns),cljs.core.str("/")].join('');
} else {
return null;
}
})()),cljs.core.str(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));

if(cljs.core.truth_(new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m))){
var seq__10833_10837 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m));
var chunk__10834_10838 = null;
var count__10835_10839 = (0);
var i__10836_10840 = (0);
while(true){
if((i__10836_10840 < count__10835_10839)){
var f_10841 = cljs.core._nth.call(null,chunk__10834_10838,i__10836_10840);
cljs.core.print.call(null,"  ");

cljs.core.prn.call(null,f_10841);

var G__10842 = seq__10833_10837;
var G__10843 = chunk__10834_10838;
var G__10844 = count__10835_10839;
var G__10845 = (i__10836_10840 + (1));
seq__10833_10837 = G__10842;
chunk__10834_10838 = G__10843;
count__10835_10839 = G__10844;
i__10836_10840 = G__10845;
continue;
} else {
var temp__4126__auto___10846 = cljs.core.seq.call(null,seq__10833_10837);
if(temp__4126__auto___10846){
var seq__10833_10847__$1 = temp__4126__auto___10846;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__10833_10847__$1)){
var c__4598__auto___10848 = cljs.core.chunk_first.call(null,seq__10833_10847__$1);
var G__10849 = cljs.core.chunk_rest.call(null,seq__10833_10847__$1);
var G__10850 = c__4598__auto___10848;
var G__10851 = cljs.core.count.call(null,c__4598__auto___10848);
var G__10852 = (0);
seq__10833_10837 = G__10849;
chunk__10834_10838 = G__10850;
count__10835_10839 = G__10851;
i__10836_10840 = G__10852;
continue;
} else {
var f_10853 = cljs.core.first.call(null,seq__10833_10847__$1);
cljs.core.print.call(null,"  ");

cljs.core.prn.call(null,f_10853);

var G__10854 = cljs.core.next.call(null,seq__10833_10847__$1);
var G__10855 = null;
var G__10856 = (0);
var G__10857 = (0);
seq__10833_10837 = G__10854;
chunk__10834_10838 = G__10855;
count__10835_10839 = G__10856;
i__10836_10840 = G__10857;
continue;
}
} else {
}
}
break;
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.prn.call(null,new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m));
} else {
}
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"special-form","special-form",-1326536374).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Special Form");

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.contains_QMARK_.call(null,m,new cljs.core.Keyword(null,"url","url",276297046))){
if(cljs.core.truth_(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))){
return cljs.core.println.call(null,[cljs.core.str("\n  Please see http://clojure.org/"),cljs.core.str(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))].join(''));
} else {
return null;
}
} else {
return cljs.core.println.call(null,[cljs.core.str("\n  Please see http://clojure.org/special_forms#"),cljs.core.str(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Macro");
} else {
}

return cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));
}
});
