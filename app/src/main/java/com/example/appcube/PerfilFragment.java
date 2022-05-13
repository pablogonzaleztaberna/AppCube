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

    //ArrayList<InfoPerfil> listaInfoPerfil;
    //RecyclerView recyclerInfoPerfil;

    ArrayList<DatosPerfil> listaDatosPerfil;
    RecyclerView recyclerDatosPerfil;

    //ArrayList<Publicacion> listaPublicaciones;
    //RecyclerView recyclerPublicacionesPerfil;

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

        //listaInfoPerfil = new ArrayList<>();
        //recyclerInfoPerfil = (RecyclerView) vista.findViewById(R.id.recyclerInfoPerfil);
        //recyclerInfoPerfil.setLayoutManager(new LinearLayoutManager(getContext()));

        listaDatosPerfil = new ArrayList<>();
        recyclerDatosPerfil = (RecyclerView) vista.findViewById(R.id.recyclerDatosPerfil);
        recyclerDatosPerfil.setLayoutManager(new LinearLayoutManager(getContext()));

        //listaPublicaciones = new ArrayList<>();
        //recyclerPublicacionesPerfil = (RecyclerView) vista.findViewById(R.id.recyclerPublicacionesPerfil);
        //recyclerPublicacionesPerfil.setLayoutManager(new LinearLayoutManager(getContext()));

        //llenarListaInfo();
        llenarListaDatos();
        //llenarListaPublicaciones();

        //AdaptadorInfoPerfil adapterI = new AdaptadorInfoPerfil(listaInfoPerfil);
        //recyclerInfoPerfil.setAdapter(adapterI);

        AdaptadorDatosPerfil adapterD = new AdaptadorDatosPerfil(listaDatosPerfil);
        recyclerDatosPerfil.setAdapter(adapterD);

        //AdaptadorPublicacion adapterP = new AdaptadorPublicacion(listaPublicaciones);
        //recyclerPublicacionesPerfil.setAdapter(adapterP);

        return vista;
    }

    /*private void llenarListaInfo() {
        listaInfoPerfil.add(new InfoPerfil(R.drawable.foto_perfil, "Alicia Maghyn", "@California"));
    }*/

    private void llenarListaDatos() {
        listaDatosPerfil.add(new DatosPerfil("76", "22", "166", "1.2k", "Implementación de tecnologías para almacenar datos modificables basados en específicos de tecnologías para almacenar datos basados en específicos para almacenar datos basados en datos basados en específicos de específicos.", R.drawable.dos, R.drawable.uno, R.drawable.tres, R.drawable.uno, R.drawable.tres, R.drawable.dos, R.drawable.uno, R.drawable.tres));
    }

    /*private void llenarListaPublicaciones() {
        listaPublicaciones.add(new Publicacion());
    }*/
}
