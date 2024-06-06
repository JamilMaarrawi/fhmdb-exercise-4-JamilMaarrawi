package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;

public class NoSortState extends SortState {

    public NoSortState(MovieListController movieListController) {
        super(movieListController);
    }

    @Override
    public void sort() {
        movieListController.setSortState(new AscendingSortState(movieListController));
        movieListController.sortAscending();
    }

    @Override
    public void keepSorted() {
        //-------------
    }
}
