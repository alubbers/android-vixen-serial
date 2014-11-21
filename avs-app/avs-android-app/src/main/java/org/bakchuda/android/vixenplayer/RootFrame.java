package org.bakchuda.android.vixenplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.bakchuda.android.filePicker.FileChooserActivity;

import java.io.File;

public class RootFrame extends ActionBarActivity {

    protected static final Boolean CHOOSER_CAN_CREATE_FILES = false;

    protected File loadedFile = null;

    protected Boolean isFileLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frame);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_frame, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.mainMenu_load) {

            setIsFileLoaded(false);

            Intent intent = new Intent(this, FileChooserActivity.class);
            intent.putExtra(FileChooserActivity.INPUT_CAN_CREATE_FILES, CHOOSER_CAN_CREATE_FILES);
            this.startActivityForResult(intent, 0);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {

            // Chosen file path is put into a bundle
            Bundle bundle = data.getExtras();

            Object fileObject = bundle.get(FileChooserActivity.OUTPUT_FILE_OBJECT);
            if(fileObject != null) {
                setLoadedFile((File) fileObject);
                setIsFileLoaded(true);

                String message = "The file path is: " + getLoadedFile().getAbsolutePath();
                Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
                toast.show();

                TextView idValText = (TextView) findViewById(R.id.id_value);
                idValText.setText(getLoadedFile().getName());
            }
        }
        else if( resultCode == Activity.RESULT_CANCELED) {
            // if the user selects cancel, but had already previously loaded a file,
            // set the flag that a file is loaded back to true
            if(!getIsFileLoaded() && getLoadedFile() != null) {
                setIsFileLoaded(true);
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public File getLoadedFile() {
        return loadedFile;
    }

    public Boolean getIsFileLoaded() {
        return isFileLoaded;
    }

    protected void setLoadedFile(File loadedFile) {
        this.loadedFile = loadedFile;
    }

    protected void setIsFileLoaded(Boolean isFileLoaded) {
        this.isFileLoaded = isFileLoaded;
    }
}
