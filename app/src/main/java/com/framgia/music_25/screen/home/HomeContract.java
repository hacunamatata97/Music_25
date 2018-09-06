package com.framgia.music_25.screen.home;

import com.framgia.music_25.data.model.Track;
import com.framgia.music_25.screen.BasePresenter;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface HomeContract {
    /**
     * View.
     */
    interface View {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter<View> {
        void loadTracksByGenre(String genre);

        List<Track> getTracks();
    }
}
