package com.example.dyv.proyectohansa

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val lista: ArrayList<Dato> = ArrayList()
    private val adapterDato =AdapterDato(lista, this)
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_datos.layoutManager = GridLayoutManager(this, 2)
        rv_datos.adapter = adapterDato

        db = FirebaseFirestore.getInstance()
        leerDato()
        btn_adicionar.setOnClickListener {
            val dato =Dato("ima1","tex1","latitud1","longitud1")
            insertarDatos(dato)
        }
        // escucharDato()
    }


    private fun insertarDatos(dato:Dato){
        db.collection("dato").document("dato2").set(dato).addOnCompleteListener {
            leerDato()
        }.addOnFailureListener {
            Toast.makeText(this, "error al insertar nuevo dato", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onStart() {
        super.onStart()
        //escucharDato()
    }

    /* val db :FirebaseFirestore = FirebaseFirestore.getInstance() */

    /*  db.collection("dato").get().addOnCompleteListener {*/
    /*  if (it.isSuccessful) {
          lista.clear()

          for(documentos in it.result){
              val imagen = documentos.getString("imagen")
              val te = documentos.getString("texto")
              val lati= documentos.getString("latitud")
              val longi = documentos.getString("longitud")

              if(imagen!=null && te!=null && lati!=null && longi!=null  )
                  lista.add(Dato(imagen,te,lati,longi))




          }
          adapterDato.notifyDataSetChanged()

      }

  }*/
    fun leerDato(){
        db.collection("dato").get().addOnCompleteListener {
            if (it.isSuccessful) {
                lista.clear()

                for(documentos in it.result){
                    val imagen = documentos.getString("imagen")
                    val te = documentos.getString("texto")
                    val lati= documentos.getString("latitud")
                    val longi = documentos.getString("longitud")

                    if(imagen!=null && te!=null && lati!=null && longi!=null  )
                        lista.add(Dato(imagen,te,lati,longi))
                }
                adapterDato.notifyDataSetChanged()

            }

        }
    }
    /*      fun escucharDato(){
              db.collection("dato").get().addOnCompleteListener {
                  if (it.isSuccessful) {
                      lista.clear()

                      for(documentos in it.result){
                          val imagen = documentos.getString("imagen")
                          val te = documentos.getString("texto")
                          val lati= documentos.getString("latitud")
                          val longi = documentos.getString("longitud")

                          if(imagen!=null && te!=null && lati!=null && longi!=null  )
                              lista.add(Dato(imagen,te,lati,longi))
                      }
                      adapterDato.notifyDataSetChanged()

                  }

              }


          }
  */
}
