package com.example.appcube;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Locale;

public class BuscarFragment extends Fragment implements SearchView.OnQueryTextListener {

    /**
     * A simple {@link Fragment} subclass.
     * Use the {@link BuscarFragment#newInstance} factory method to
     * create an instance of this fragment.
     */
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

        SearchView svAmigos;
        ArrayList<Amigo> listaAmigos;
        RecyclerView recyclerAmigos;
        AdaptadorAmigo adapter;

        public BuscarFragment() {
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
        public static BuscarFragment newInstance(String param1, String param2) {
            BuscarFragment fragment = new BuscarFragment();
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
            View vista = inflater.inflate(R.layout.fragment_buscar, container, false);

            listaAmigos = new ArrayList<>();
            recyclerAmigos = (RecyclerView) vista.findViewById(R.id.recyclerId);
            recyclerAmigos.setLayoutManager(new LinearLayoutManager(getContext()));

            svAmigos = (SearchView) vista.findViewById(R.id.svAmigos);
            svAmigos.setOnQueryTextListener(this);

            llenarListado();

            adapter = new AdaptadorAmigo(listaAmigos);
            recyclerAmigos.setAdapter(adapter);

            return vista;
        }

        private void llenarListado() {
            listaAmigos.add(new Amigo("Hurin Seary", "¿Qué tal cómo estás?", "Seguir", R.drawable.ic_baseline_person_24));
            listaAmigos.add(new Amigo("Víctor Exrixón", "¿Qué tal cómo estás?", "Seguir", R.drawable.ic_baseline_person_2_24));
            listaAmigos.add(new Amigo("surfiya zakir", "¿Qué tal cómo estás?", "Siguiente", R.drawable.ic_baseline_person_2_24));
            listaAmigos.add(new Amigo("Juan Ive", "¿Qué tal cómo estás?", "Seguir", R.drawable.ic_baseline_person_24));
            listaAmigos.add(new Amigo("Costa de Goria", "¿Qué tal cómo estás?", "Seguir", R.drawable.ic_baseline_person_2_24));
            listaAmigos.add(new Amigo("Juan Ive", "¿Qué tal cómo estás?", "Dejar de Seguir", R.drawable.ic_baseline_person_24));
            listaAmigos.add(new Amigo("Costa de Goria", "¿Qué tal cómo estás?", "Seguir", R.drawable.ic_baseline_person_2_24));
            listaAmigos.add(new Amigo("Juan Ive", "¿Qué tal cómo estás?", "Seguir", R.drawable.ic_baseline_person_24));
            listaAmigos.add(new Amigo("Costa de Goria", "¿Qué tal cómo estás?", "Siguiente", R.drawable.ic_baseline_person_2_24));
            listaAmigos.add(new Amigo("Hurin Seary", "¿Qué tal cómo estás?", "Dejar de Seguir", R.drawable.ic_baseline_person_24));
        }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrar(s);
        return false;
    }
}
