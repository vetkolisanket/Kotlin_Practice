inline fun inlined(block: () -> Unit) {
    println("before")
    block()
    println("after")
}

fun noninlined(block: () -> Unit) {
    println("before")
    block()
    println("after")
}

fun main() {
    //println("do something here") replaces block call and the inlined function is copied to the call site
    inlined {
        println("do something here")
    }
    //will create an instance of block function containing println("do something here") in its invoke method
    /**
     * nonInlined(new Function() {
    @Override
    public void invoke() {
    System.out.println("do something here");
    }
    });
     */
    noninlined {
        println("do something else here")
    }
}