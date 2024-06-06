package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;

public class AscendingSortState extends SortState {

    public AscendingSortState(MovieListController movieListController) {
        super(movieListController);
    }

    @Override
    public void sort() {
        movieListController.setSortState(new DescendingSortState(movieListController));
        movieListController.sortDescending();
    }

    @Override
    public void keepSorted() {
        movieListController.sortAscending();
    }
}
