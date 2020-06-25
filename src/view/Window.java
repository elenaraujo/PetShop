package view;

import control.Service;
import java.io.IOException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.domain.Product;

public class Window extends javax.swing.JFrame {

    Service s = new Service();
    TreeMap<Integer, Product> treemap;
    TreeMap<Integer, Product> treemapTemp;
    String acao = "novo";
    Integer codigoAntigo;

    public Window() {
        initComponents();
        setLocationRelativeTo(null);
        treemap = s.obterDadosTxt();
        treemapTemp = new TreeMap<>();
        loadTable();
        manipulaInterface(true, true, false, false);
    }

    public void loadTable() {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código", "Nome", "Valor", "Data"}, 0);
        tbl_produtos.setRowSorter(new TableRowSorter(modelo));
        int contador = 0;

        if (treemap.isEmpty() == false) {
            if (treemap.size() >= treemap.lastKey()) {
                contador = treemap.size();
            } else {
                contador = treemap.lastKey();
            }

            for (int i = 0; i <= contador; i++) {
                if (treemap.containsKey(i)) {
                    modelo.addRow(new Object[]{
                        treemap.get(i).getCodigo(),
                        treemap.get(i).getNome(),
                        treemap.get(i).getValor(),
                        treemap.get(i).getDataAlteracao()
                    });
                }
            }
        }

        tbl_produtos.setModel(modelo);
        tbl_produtos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_produtos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbl_produtos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl_produtos.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    public void filtrarLista() {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código", "Nome", "Valor", "Data"}, 0);
        tbl_produtos.setRowSorter(new TableRowSorter(modelo));
        int contador = 0;

        if (treemapTemp.isEmpty() == false) {
            if (treemapTemp.size() >= treemapTemp.lastKey()) {
                contador = treemapTemp.size();
            } else {
                contador = treemapTemp.lastKey();
            }

            for (int i = 0; i <= contador; i++) {
                if (treemapTemp.containsKey(i)) {
                    modelo.addRow(new Object[]{
                        treemapTemp.get(i).getCodigo(),
                        treemapTemp.get(i).getNome(),
                        treemapTemp.get(i).getValor(),
                        treemapTemp.get(i).getDataAlteracao()
                    });
                }
            }
        }

        tbl_produtos.setModel(modelo);
        tbl_produtos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_produtos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbl_produtos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl_produtos.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private void manipulaInterface(Boolean limparCampos, Boolean habilitarNovoEBusca, Boolean habilitarButtonsETextAreasInferiores, Boolean habilitarEditarEExcluir) {

        if (limparCampos) {
            c_codigo.setText("");
            c_nome.setText("");
            c_valor.setText("");
        }

        btn_novo.setEnabled(habilitarNovoEBusca);
        cb_busca.setEnabled(habilitarNovoEBusca);
        c_busca.setEnabled(habilitarNovoEBusca);
        btn_busca.setEnabled(habilitarNovoEBusca);

        btn_salvar.setEnabled(habilitarButtonsETextAreasInferiores);
        btn_cancelar.setEnabled(habilitarButtonsETextAreasInferiores);
        c_codigo.setEnabled(habilitarButtonsETextAreasInferiores);
        c_nome.setEnabled(habilitarButtonsETextAreasInferiores);
        c_valor.setEnabled(habilitarButtonsETextAreasInferiores);

        btn_editar.setEnabled(habilitarEditarEExcluir);
        btn_excluir.setEnabled(habilitarEditarEExcluir);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_produtos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        c_codigo = new JtextFieldSomenteNumeros();
        c_nome = new javax.swing.JTextField();
        c_valor = new JtextFieldSomenteNumeros();
        btn_salvar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        c_busca = new javax.swing.JTextField();
        cb_busca = new javax.swing.JComboBox<>();
        btn_busca = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Produtos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbl_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "Nome", "Valor", "Data Alteração"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_produtos.getTableHeader().setReorderingAllowed(false);
        tbl_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_produtosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_produtos);
        if (tbl_produtos.getColumnModel().getColumnCount() > 0) {
            tbl_produtos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_produtos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_produtos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbl_produtos.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Valor: R$");

        c_codigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_codigoActionPerformed(evt);
            }
        });

        c_nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        c_valor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_salvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_salvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_novo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_editar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_excluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Buscar produto por:");

        c_busca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cb_busca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_busca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome" }));

        btn_busca.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        btn_busca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/lupa.png"))); // NOI18N
        btn_busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscaActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/close.png"))); // NOI18N
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(c_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_clear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_busca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c_busca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_novo)
                    .addComponent(btn_editar)
                    .addComponent(btn_excluir))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Produtos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        acao = "Editar";
        codigoAntigo = Integer.parseInt(c_codigo.getText());
        manipulaInterface(false, false, true, false);
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        acao = "Novo";
        manipulaInterface(true, false, true, false);
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        manipulaInterface(true, true, false, false);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void c_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_codigoActionPerformed

    }//GEN-LAST:event_c_codigoActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed

        Integer cod = Integer.parseInt(c_codigo.getText());
        String nome = c_nome.getText();
        Double valor = Double.parseDouble(c_valor.getText());

        Product p = new Product(cod, nome, valor);
        int contador = 0;

        if (acao.equals("Editar")) {

            if (treemap.size() >= treemap.lastKey()) {
                contador = treemap.size();
            } else {
                contador = treemap.lastKey();
            }

            for (int i = 0; i <= contador; i++) {
                if (treemap.containsKey(i)) {
                    if ((treemap.get(i).getCodigo().equals(codigoAntigo))) {
                        treemap.remove(i);
                        if (treemap.isEmpty()) {
                            treemap.put(0, p);
                        } else {
                            treemap.put(i, p);
                        }
                        break;
                    }
                }
            }
        } else {
            if (treemap.isEmpty()) {
                treemap.put(0, p);
            } else {
                treemap.put(treemap.lastKey() + 1, p);
            }
        }

        loadTable();
        manipulaInterface(true, true, false, false);
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void tbl_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_produtosMouseClicked

        int index = tbl_produtos.getSelectedRow();
        if (index >= 0 && index < tbl_produtos.getRowCount()) {
            c_codigo.setText(tbl_produtos.getModel().getValueAt(index, 0).toString());
            c_nome.setText(tbl_produtos.getModel().getValueAt(index, 1).toString());
            c_valor.setText(tbl_produtos.getModel().getValueAt(index, 2).toString());
            manipulaInterface(false, true, false, true);
        }
    }//GEN-LAST:event_tbl_produtosMouseClicked

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed

        Integer cod = Integer.parseInt(c_codigo.getText());

        for (int i = 0; i < treemap.size(); i++) {
            if (treemap.containsKey(i)) {
                if ((treemap.get(i).getCodigo().equals(cod))) {
                    treemap.remove(i);
                    break;
                }
            }
        }
        loadTable();
        manipulaInterface(true, true, false, true);
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            s.gravarDadosTxt(treemap);
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btn_buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscaActionPerformed

        int n = treemap.size();
        String busca = c_busca.getText();
        String filtro = cb_busca.getSelectedItem().toString();
        String a = "";

        if (filtro.equals("Código")) {
            for (int i = 0; i <= n; i++) {
                if (treemap.containsKey(i)) {
                    a = treemap.get(i).getCodigo().toString();
                    if (a.startsWith(busca)) {
                        treemapTemp.put(i, treemap.get(i));
                    }
                }
            }
        } else {
            for (int i = 0; i <= n; i++) {
                if (treemap.containsKey(i)) {
                    a = treemap.get(i).getNome();
                    if (a.startsWith(busca)) {
                        treemapTemp.put(i, treemap.get(i));
                    }
                }
            }
        }
        filtrarLista();
    }//GEN-LAST:event_btn_buscaActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        c_busca.setText("");
        loadTable();
    }//GEN-LAST:event_btn_clearActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_busca;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField c_busca;
    private javax.swing.JTextField c_codigo;
    private javax.swing.JTextField c_nome;
    private javax.swing.JTextField c_valor;
    private javax.swing.JComboBox<String> cb_busca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tbl_produtos;
    // End of variables declaration//GEN-END:variables
}
