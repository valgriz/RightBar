package com.valgriz.rightbar.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import com.valgriz.rightbar.Main;

/**
 * Created by Steven on 7/6/2015.
 */
public class GameFragment extends AndroidFragmentApplication {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return initializeForView(new Main());
	}
}
