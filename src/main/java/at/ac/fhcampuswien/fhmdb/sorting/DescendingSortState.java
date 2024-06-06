package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;

public class DescendingSortState extends SortState {

    public DescendingSortState(MovieListController movieListController) {
        super(movieListController);
    }

    @Override
    public void sort() {
        movieListController.setSortState(new AscendingSortState(movieListController));
        movieListController.sortAscending();
    }

    @Override
    public void keepSorted() {
        movieListController.sortDescending();
    }
}
