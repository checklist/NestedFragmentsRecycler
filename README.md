# NestedFragmentsRecycler
This project demonstrates how to Nest Fragments using a RecyclerView on Android. 
We are nesting FragmentA in the main activity. FragmentA has a RecyclerView with and adapter: FragmentAAdapter. 
Each row in the adapter contains a FrameLayout which at run time loads FragmentB into it. FragmentB only contains a simple TextView

Due to having to add multiple Fragments inside the adapter (which in return is nested in FragmentA), we need to give each layout for FragmentB its own unique id. We do that by generating it manually and setting it.


