package id.my.note.todolist;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by Admin on 26/08/2017.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        //ketika tanggal dipilih
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //ketika dialog dipanggil
        final Calendar c = Calendar.getInstance();
        int tahun = c.get(Calendar.YEAR);
        int bulan = c.get(Calendar.MONTH);
        int hari = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,tahun,bulan,hari);
    }
}
