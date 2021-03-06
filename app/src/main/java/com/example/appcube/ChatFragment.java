package com.example.appcube;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment implements SearchView.OnQueryTextListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    SearchView svChat;
    ArrayList<AmigoConectado> listaAmigosConectados;
    RecyclerView recyclerAmigosConectados;
    ArrayList<Mensaje> listaMensajes;
    RecyclerView recyclerMensajes;
    AdaptadorMensaje adapter;

    public ChatFragment() {
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
    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
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
        View vista = inflater.inflate(R.layout.fragment_chat, container, false);
        listaAmigosConectados = new ArrayList<>();
        recyclerAmigosConectados = (RecyclerView) vista.findViewById(R.id.recyclerAmigosConectados);
        recyclerAmigosConectados.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        listaMensajes = new ArrayList<>();
        recyclerMensajes = (RecyclerView) vista.findViewById(R.id.recyclerMensajes);
        recyclerMensajes.setLayoutManager(new LinearLayoutManager(getContext()));

        svChat = (SearchView) vista.findViewById(R.id.svChat);
        svChat.setOnQueryTextListener(this);

        llenarListaAmigosConectados();
        llenarListaMensajes();

        AdaptadorAmigoConectado adapterAC = new AdaptadorAmigoConectado(listaAmigosConectados);
        recyclerAmigosConectados.setAdapter(adapterAC);

        adapter = new AdaptadorMensaje(listaMensajes);
        recyclerMensajes.setAdapter(adapter);

        return vista;
    }

    private void llenarListaAmigosConectados() {
        listaAmigosConectados.add(new AmigoConectado(R.drawable.ic_baseline_person_24, "Hurin"));
        listaAmigosConectados.add(new AmigoConectado(R.drawable.ic_baseline_person_2_24, "V??ctor"));
        listaAmigosConectados.add(new AmigoConectado(R.drawable.ic_baseline_person_24, "Surliya"));
        listaAmigosConectados.add(new AmigoConectado(R.drawable.ic_baseline_person_2_24, "Juan"));
        listaAmigosConectados.add(new AmigoConectado(R.drawable.ic_baseline_person_24, "Goria"));
        listaAmigosConectados.add(new AmigoConectado(R.drawable.ic_baseline_person_2_24, "Juan"));
        listaAmigosConectados.add(new AmigoConectado(R.drawable.ic_baseline_person_24, "V??ctor"));
        listaAmigosConectados.add(new AmigoConectado(R.drawable.ic_baseline_person_2_24, "Hurin"));
        listaAmigosConectados.add(new AmigoConectado(R.drawable.ic_baseline_person_24, "Surliya"));
        listaAmigosConectados.add(new AmigoConectado(R.drawable.ic_baseline_person_2_24, "Goria"));
    }

    private void llenarListaMensajes() {
        listaMensajes.add(new Mensaje(R.drawable.ic_baseline_person_24, "Hurin Seary", "??Qu?? tal c??mo est??s?", "15:41", "3"));
        listaMensajes.add(new Mensaje(R.drawable.ic_baseline_person_2_24, "V??ctor Exrix??n", "??Qu?? tal c??mo est??s?", "15:41", "3"));
        listaMensajes.add(new Mensaje(R.drawable.ic_baseline_person_24, "surfiya zakir", "??Qu?? tal c??mo est??s?", "Ayer", "1"));
        listaMensajes.add(new Mensaje(R.drawable.ic_baseline_person_2_24, "Juan Ive", "??Qu?? tal c??mo est??s?", "15:41"));
        listaMensajes.add(new Mensaje(R.drawable.ic_baseline_person_24, "Costa de Goria", "??Qu?? tal c??mo est??s?", "15:41"));
        listaMensajes.add(new Mensaje(R.drawable.ic_baseline_person_2_24, "Juan Ive", "??Qu?? tal c??mo est??s?", "15:41"));
        listaMensajes.add(new Mensaje(R.drawable.ic_baseline_person_24, "Costa de Goria", "??Qu?? tal c??mo est??s?", "15:41"));
        listaMensajes.add(new Mensaje(R.drawable.ic_baseline_person_2_24, "Hurvin Seary", "??Qu?? tal c??mo est??s?", "10:20"));
        listaMensajes.add(new Mensaje(R.drawable.ic_baseline_person_24, "Juan Ive", "??Qu?? tal c??mo est??s?", "09:21"));
        listaMensajes.add(new Mensaje(R.drawable.ic_baseline_person_2_24, "V??ctor Exrix??n", "??Qu?? tal c??mo est??s?", "Ayer"));
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

