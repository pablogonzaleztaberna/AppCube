package com.example.appcube;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<PublicacionPerfil> listaPublicacionesPerfil;
    RecyclerView recyclerPublicacionesPerfil;

    public PerfilFragment() {
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
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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
        View vista = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaPublicacionesPerfil = new ArrayList<>();
        recyclerPublicacionesPerfil = (RecyclerView) vista.findViewById(R.id.recyclerPublicacionesPerfil);
        recyclerPublicacionesPerfil.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaPublicacionesPerfil();

        AdaptadorPerfil adapter = new AdaptadorPerfil(listaPublicacionesPerfil);
        recyclerPublicacionesPerfil.setAdapter(adapter);

        return vista;
    }

    private void llenarListaPublicacionesPerfil() {
        listaPublicacionesPerfil.add(new PublicacionPerfil(R.drawable.ic_baseline_person_2_24, R.drawable.uno, "eduardo kelly", "Implementación de tecnologías para almacenar datos inalterables en base a datos específicos."));
        listaPublicacionesPerfil.add(new PublicacionPerfil(R.drawable.ic_baseline_person_2_24, R.drawable.dos, "Víctor Exrix", "Implementación de tecnologías para almacenar datos inalterables en base a datos específicos."));
        listaPublicacionesPerfil.add(new PublicacionPerfil(R.drawable.ic_baseline_person_2_24, R.drawable.tres, "Hurin Seary", "Implementación de tecnologías para almacenar datos inalterables en base a datos específicos."));
    }
}
