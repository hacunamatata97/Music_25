package com.framgia.music_25.screen.home;

import com.framgia.music_25.screen.BasePresenter;

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
    }
}
