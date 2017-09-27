package agenda;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaAgenda extends JFrame {

	private JPanel panelGeneral;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textDomicilio;
	private JTextField textCorreo;
	private JTextField textTelefono;
	
	DefaultListModel<Persona> modelo ;//= new DefaultListModel<Persona>();
	private final ButtonGroup buttonGroup = new ButtonGroup();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgenda frame = new VentanaAgenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaAgenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 400);
		panelGeneral = new JPanel();
		panelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelGeneral);
		panelGeneral.setLayout(new BoxLayout(panelGeneral, BoxLayout.X_AXIS));
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(SystemColor.activeCaptionBorder);
		panelDatos.setBorder(new TitledBorder(new LineBorder(new Color(244, 247, 252), 5, true), "Datos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(244, 247, 252)));
		panelGeneral.add(panelDatos);
		panelDatos.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentro = new JPanel();
		panelDatos.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNombre.setIcon(new ImageIcon(VentanaAgenda.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));
		lblNombre.setBackground(Color.BLACK);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblNombre);
		
		textNombre = new JTextField();
		panelCentro.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad *");
		lblEdad.setForeground(SystemColor.textHighlight);
		lblEdad.setBackground(SystemColor.controlHighlight);
		lblEdad.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblEdad.setIcon(new ImageIcon(VentanaAgenda.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setBackground(SystemColor.controlHighlight);
		panelCentro.add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblDomicilio.setIcon(new ImageIcon(VentanaAgenda.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));
		lblDomicilio.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblDomicilio);
		
		textDomicilio = new JTextField();
		panelCentro.add(textDomicilio);
		textDomicilio.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(SystemColor.textHighlight);
		lblCorreo.setBackground(SystemColor.controlHighlight);
		lblCorreo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblCorreo.setIcon(new ImageIcon(VentanaAgenda.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setBackground(SystemColor.controlHighlight);
		panelCentro.add(textCorreo);
		textCorreo.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setIcon(new ImageIcon(VentanaAgenda.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));
		panelCentro.add(lblTelefono);
		
		textTelefono = new JTextField();
		panelCentro.add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero *");
		lblGenero.setForeground(SystemColor.textHighlight);
		lblGenero.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblGenero.setIcon(new ImageIcon(VentanaAgenda.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblGenero);
		
		JPanel panelGenero = new JPanel();
		panelGenero.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGenero.setBackground(SystemColor.controlHighlight);
		panelCentro.add(panelGenero);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBackground(SystemColor.controlHighlight);
		rdbtnHombre.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		buttonGroup.add(rdbtnHombre);
		panelGenero.add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBackground(SystemColor.controlHighlight);
		rdbtnMujer.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		buttonGroup.add(rdbtnMujer);
		panelGenero.add(rdbtnMujer);
		
		JPanel panelBotones = new JPanel();
		panelDatos.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(new Color(230, 230, 250));
		btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNuevo.setForeground(SystemColor.textHighlight);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNuevo.setForeground(SystemColor.black);
			}
		});
		btnNuevo.setIcon(new ImageIcon(VentanaAgenda.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		panelBotones.add(btnNuevo);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAgregar.setForeground(SystemColor.textHighlight);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAgregar.setForeground(SystemColor.black);
			}
		});
		btnAgregar.setBackground(new Color(230, 230, 250));
		btnAgregar.setIcon(new ImageIcon(VentanaAgenda.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		/*Su ActionListener ya esta declarado mas abajo*/
		panelBotones.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEditar.setForeground(SystemColor.textHighlight);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEditar.setForeground(SystemColor.black);
			}
		});
		btnEditar.setBackground(new Color(230, 230, 250));
		btnEditar.setIcon(new ImageIcon(VentanaAgenda.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		panelBotones.add(btnEditar);
		btnEditar.setEnabled(false);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminar.setForeground(SystemColor.textHighlight);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEliminar.setForeground(SystemColor.black);
			}
		});
		btnEliminar.setBackground(new Color(230, 230, 250));
		btnEliminar.setIcon(new ImageIcon(VentanaAgenda.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		panelBotones.add(btnEliminar);
		btnEliminar.setEnabled(false);
		
		JPanel panelContactos = new JPanel();
		panelContactos.setBackground(SystemColor.controlHighlight);
		panelContactos.setBorder(new TitledBorder(new LineBorder(new Color(160, 160, 160), 5, true), "Contactos", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.menuText));
		panelGeneral.add(panelContactos);
		panelContactos.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelContactos.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(153, 180, 209), 8));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int index = list.getSelectedIndex();
				if(index!=-1) {
					Persona p = modelo.get(index);
					//JOptionPane.showMessageDialog(panelGeneral, modelo.get(index).toString());
					textNombre.setText(modelo.getElementAt(index).getNombre());
					textDomicilio.setText(modelo.getElementAt(index).getDomicilio());
					textCorreo.setText(modelo.getElementAt(index).getCorreo());
					textEdad.setText(String.valueOf(modelo.getElementAt(index).getEdad()));
					textTelefono.setText(modelo.getElementAt(index).getTelefono());
					btnAgregar.setEnabled(false);
					btnEditar.setEnabled(true);
					btnEliminar.setEnabled(true);
					if(p.getGenero() == Genero.HOMBRE) {
						rdbtnHombre.setSelected(true);
					}
					else {
						rdbtnMujer.setSelected(true);
					}
				}

			}
		});
		scrollPane.setViewportView(list);
		
		try {
			FileInputStream File= new FileInputStream("contactos.txt");
			ObjectInputStream ois = new ObjectInputStream(File);
			modelo = (DefaultListModel<Persona>)ois.readObject();
			File.close();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.setModel(modelo);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textNombre.getText().equals("") || buttonGroup.isSelected(null) || textEdad.getText().equals("")) {
					JOptionPane.showMessageDialog(panelGeneral, "Los campos con * son obligatorios ");
				}
				else {
					String nombre = textNombre.getText();
					int edad = Integer.parseInt(textEdad.getText());
					Genero genero = rdbtnHombre.isSelected()?Genero.HOMBRE:Genero.MUJER;
					String domicilio = textDomicilio.getText();
					String telefono = textTelefono.getText();
					String correo = textCorreo.getText();
					Persona p = new Persona(nombre,edad,genero,domicilio,telefono,correo);
					modelo.addElement(p);
					//Esta parte del codigo va en todas las acciones de los botones
					try {
						FileOutputStream file = new FileOutputStream("contactos.txt");
						ObjectOutputStream oos = new ObjectOutputStream(file);
						oos.writeObject(modelo);
						file.close();
						oos.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				String nombre = textNombre.getText();
				int edad = Integer.parseInt(textEdad.getText());
				Genero genero = rdbtnHombre.isSelected()?Genero.HOMBRE:Genero.MUJER;
				String domicilio = textDomicilio.getText();
				String telefono = textTelefono.getText();
				String correo = textCorreo.getText();
				Persona p = new Persona(nombre,edad,genero,domicilio,telefono,correo);
				modelo.setElementAt(p, index);
				
				//Esta parte del codigo va en todas las acciones de los botones
				try {
					FileOutputStream file = new FileOutputStream("contactos.txt");
					ObjectOutputStream oos = new ObjectOutputStream(file);
					oos.writeObject(modelo);
					file.close();
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				Persona p = modelo.get(index);
				modelo.remove(index);
				textNombre.setText(null);
				textEdad.setText(null);
				textCorreo.setText(null);
				textDomicilio.setText(null);
				textTelefono.setText(null);
				buttonGroup.clearSelection();
				btnAgregar.setEnabled(true);
				btnNuevo.setEnabled(true);
				btnEditar.setEnabled(false);
				btnEliminar.setEnabled(false);
				try {
					FileOutputStream file = new FileOutputStream("contactos.txt");
					ObjectOutputStream oos = new ObjectOutputStream(file);
					oos.writeObject(modelo);
					file.close();
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNombre.setText(null);
				textEdad.setText(null);
				textCorreo.setText(null);
				textDomicilio.setText(null);
				textTelefono.setText(null);
				btnEditar.setEnabled(false);
				btnEliminar.setEnabled(false);
				buttonGroup.clearSelection();
				btnAgregar.setEnabled(true);
			}
		});
		
	}

}