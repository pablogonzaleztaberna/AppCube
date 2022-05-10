package com.example.appcube;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CuentosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class CuentosFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Resumen> listaResumenes;
    RecyclerView recyclerResumenes;

    public CuentosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPersonajesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CuentosFragment newInstance(String param1, String param2) {
        CuentosFragment fragment = new CuentosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_cuentos, container, false);
        listaResumenes = new ArrayList<>();
        recyclerResumenes = (RecyclerView) vista.findViewById(R.id.recyclerResumenes);
        recyclerResumenes.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        llenarListaResumenes();

        AdaptadorResumen adapter = new AdaptadorResumen(listaResumenes);
        recyclerResumenes.setAdapter(adapter);

        return vista;
    }

    private void llenarListaResumenes() {
        listaResumenes.add(new Resumen(R.drawable.ic_baseline_person_2_24, R.drawable.dos, "Hurin Seary"));
        listaResumenes.add(new Resumen(R.drawable.ic_baseline_person_24, R.drawable.uno, "Víctor Exrix"));
        listaResumenes.add(new Resumen(R.drawable.ic_baseline_person_2_24, R.drawable.tres, "surfiya zakir"));
        listaResumenes.add(new Resumen(R.drawable.ic_baseline_person_24, R.drawable.dos,"Víctor Exrix"));
        listaResumenes.add(new Resumen(R.drawable.ic_baseline_person_2_24, R.drawable.uno,"Hurin Seary"));
    }
}